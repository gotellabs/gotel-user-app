
object Dependencies{

    object Version{
        const val kotlin = "1.3.71"
        const val material = "1.1.0"
        const val junit = "4.12"
        const val junitX = "1.1.1"
        const val room = "2.2.5"
        const val constraintLayout = "1.1.3"
        const val appCompat = "1.1.0"
        const val coreKtx = "1.2.0"
        const val coroutines = "1.3.5"
        const val espresso = "3.2.0"
        const val fFireStore = "21.4.1"
        const val fMessaging = "20.1.3"
        const val fAuth = "19.3.0"
        const val dagger2 = "2.27"
    }

    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Version.kotlin}"
    const val material = "com.google.android.material:material:${Version.material}"
    const val junit = "junit:junit:${Version.junit}"
    const val junitX = "androidx.test.ext:junit:${Version.junitX}"
    val roomRuntime = "androidx.room:room-runtime:${Version.room}"
    const val roomCompiler = "androidx.room:room-compiler:${Version.room}"
    const val roomKtx = "androidx.room:room-ktx:${Version.room}"
    const val coreKtx = "androidx.core:core-ktx:${Version.coreKtx}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Version.constraintLayout}"
    const val appCompat = "androidx.appcompat:appcompat:${Version.appCompat}"
    const val espresso = "androidx.test.espresso:espresso-core:${Version.espresso}"
    const val firebaseFireStore = "com.google.firebase:firebase-firestore:${Version.fFireStore}"
    const val firebaseAuth = "com.google.firebase:firebase-auth:${Version.fAuth}"
    const val firebaseMessaging = "com.google.firebase:firebase-messaging:${Version.fMessaging}"

    const val dagger = "com.google.dagger:dagger:${Version.dagger2}"
    const val daggerCompiler = "com.google.dagger:dagger-compiler:${Version.dagger2}"
    const val daggerAndroid = "com.google.dagger:dagger-android:${Version.dagger2}"
    const val daggerAndroidSupport = "com.google.dagger:dagger-android-support:${Version.dagger2}"
    const val daggerAndroidProcessor =
        "com.google.dagger:dagger-android-processor:${Version.dagger2}"


}