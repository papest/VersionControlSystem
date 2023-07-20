fun parsingNickname(emailString: String): String {
    val symbolsForNickname = "[_.]".toRegex()
    val nicknameString = emailString.split("@").first()
    val (firstName, lastName ) = nicknameString.split(symbolsForNickname)
    return "${firstName.capitalize()} ${lastName.capitalize()}"
}