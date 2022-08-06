package com.umc.battles.ui.auth

import android.content.Intent
import android.util.Log
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.umc.battles.ApplicationClass.Companion.TAG
import com.umc.battles.databinding.ActivityLoginBinding
import com.umc.battles.ui.BaseActivity
import com.umc.battles.ui.auth.bottomsheet.SignUpFragment
import com.umc.battles.ui.main.MainActivity

class LoginActivity : BaseActivity<ActivityLoginBinding>(ActivityLoginBinding::inflate) {

    /*
    * credentials 파일을 이미 등록해서 이를 통해 접근을 해야 했음
    * 하지만, 여기서 WEB_CLIENT_ID를 새로 갱신해서 권한 문제가 발생함
    * 따라서 12500, 10 에러가 호출된 것임
    * 이를 제거하니까 email정보를 받아올 수 있다.
    */
    //private val WEB_CLIENT_ID = "762666871978-2tq7fs72c03ub8ctj74luf07qfjjj226.apps.googleusercontent.com"

    private lateinit var googleSignResultLauncher: ActivityResultLauncher<Intent>
    private val signUpBottomSheet =
        SignUpFragment().apply { dismissCallback = this@LoginActivity::dismissBottomSheet }

    override fun initAfterBinding() {
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .build()
        val mGoogleSignInClient = GoogleSignIn.getClient(this, gso)

        googleSignResultLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result ->
            val task: Task<GoogleSignInAccount> =
                GoogleSignIn.getSignedInAccountFromIntent(result.data)
            handleSignInResult(task)
        }

        binding.btnGoogleLogin.setOnClickListener {
            val signIntent: Intent = mGoogleSignInClient.signInIntent
            googleSignResultLauncher.launch(signIntent)
        }
    }

    private fun handleSignInResult(completedTask: Task<GoogleSignInAccount>) {
        try {
            val account = completedTask.getResult(ApiException::class.java)
            val email = account?.email.toString()
            startActivityWithClear(MainActivity::class.java)
        } catch (e: ApiException) {
            Log.e("Google account", "signInResult:failed Code = " + e.statusCode)
            signUpBottomSheet.show(supportFragmentManager, TAG)
        }
    }

    override fun onStart() {
        super.onStart()

        val account = GoogleSignIn.getLastSignedInAccount(this)
        if (account == null) {
            Log.e("Google account", "로그인 안되있음")
        } else {
            Log.e("Google account", "로그인 완료된 상태")
        }
    }

    private fun dismissBottomSheet() {
        Log.d(TAG, "dismissBottomSheet: Dismiss")
        signUpBottomSheet.dismiss()
    }
}