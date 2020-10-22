package dev.orf1.foundation.enums

import dev.orf1.foundation.Foundation

enum class Lang (val message:String?, val path:String){
    MESSAGE_TEST(Foundation.lang.get().getString("message-test"), "message-test")
}