
object Dependencies{

    object Version{
        const val kotlin = "1.3.71"
        const val material = "1.1.0"
        const val junit = "4.12"
        const val room = "2.1.0"

    }

    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Version.kotlin}"
    const val material = "com.google.android.material:material:${Version.material}"
    const val junit = "junit:junit:${Version.junit}"
    const val roomRuntime = "androidx.room:room-runtime:${Version.room}"
    const val roomCompiler = "androidx.room:room-compiler:${Version.room}"
    const val roomKtx = "androidx.room:room-ktx:${Version.room}"

}