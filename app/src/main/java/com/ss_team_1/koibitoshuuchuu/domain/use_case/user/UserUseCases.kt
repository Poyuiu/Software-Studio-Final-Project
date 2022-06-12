package com.ss_team_1.koibitoshuuchuu.domain.use_case.user

data class UserUseCases (
    val getUserInfo: GetUserInfo,
    val setId: SetId,
    val setUserName: SetUserName,
    val setPhotoUrl: SetPhotoUrl,
    val setGender: SetGender,
    val setBirthday: SetBirthday,
    val setJoinDate: SetJoinDate,
    val updateMoney: UpdateMoney,
    val updateGem: UpdateGem,
    val setLastUsedCharacterId: SetLastUsedCharacterId
)