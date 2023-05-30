package com.poe.poegps.feature.domain.repository

import com.poe.poegps.feature.data.remote.model.LoginResponse
import com.poe.poegps.feature.data.remote.model.SavePillarsResponse
import com.poe.poegps.feature.data.remote.utils.ApiResponse
import com.poe.poegps.feature.domain.model.Line
import com.poe.poegps.feature.domain.model.Pillar
import com.poe.poegps.feature.domain.model.Tp
import kotlinx.coroutines.flow.Flow

interface ObjectsRepository {

    //логин
    fun auth(login: String, password: String): Flow<ApiResponse<LoginResponse>>

    //Выгрузка опор из БД
    fun uploadSavedPillars(token: String): Flow<ApiResponse<SavePillarsResponse>>

    //загрузка линий из апи
    suspend fun downloadLines(filial: String, token: String)

    //Получение списка ТП из апи
    suspend fun downloadTPs(filial: String, token: String)

    //Получение списка ПС из апи
    suspend fun downloadPss(token: String)

    //Получение списка опор из апи
    suspend fun downloadPillars(filial: String, token: String)

    //Получение линий 10 из БД
    fun searchLine10(tplnr: String): Flow<List<Line>>

    //Получение линий 04 из БД
    fun searchLine04(tplnr: String): Flow<List<Line>>

    //Получение абонентских линий 10 из БД
    fun searchAbonLine10(tplnr: String): Flow<List<Line>>

    //Получение абонентских линий 04 из БД
    fun searchAbonLine04(tplnr: String): Flow<List<Line>>

    //Получение ТП из БД по клику
    fun searchTP(tplnr: String, abonState: Boolean): Flow<List<Tp>>

    //Получение ПС из БД по клику
    fun searchPS(tplnr: String): Flow<List<Tp>>

    //Получение списка линий по категории
    fun getLineList10(): Flow<List<Line>>

    fun getLineList04(): Flow<List<Line>>

    //Получение списка ТП из БД
    fun getTpList(): Flow<List<Tp>>

    fun getPillarList(tplnr: String): Flow<List<Pillar>>

    fun getSavedPillars(pltxt: String): Flow<List<Pillar>>

    suspend fun savePillar(pillar: Pillar): Long

    suspend fun copyPillarForOtp(pillar: Pillar)

    suspend fun deletePillar(pillar: Pillar)

    suspend fun getParentName(tplnr: String): String

    suspend fun saveLine04(line: Line)

    suspend fun saveLine10(line: Line)

    suspend fun saveAbonLine04(line: Line)

    suspend fun saveAbonLine10(line: Line)

    suspend fun deleteLine04(pltxt: String)

    suspend fun deleteLine10(pltxt: String)

    suspend fun deleteAbonLine04(pltxt: String)

    suspend fun deleteAbonLine10(pltxt: String)

}