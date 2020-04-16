package com.gotellabs.domain.usecases


import com.gotellabs.domain.repository.HotelRepository
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

/**
 * Created by Enzo Lizama Paredes on 4/16/20.
 * Contact: lizama.enzo@gmail.com
 */

@RunWith(MockitoJUnitRunner::class)
class RetrieveHotelsUseCaseTest {

    @Mock
    private lateinit var hotelRepositoryMock: HotelRepository

    private lateinit var hotelsUseCase: RetrieveHotelsUseCase

    @Before
    fun setUp() {
        hotelsUseCase = RetrieveHotelsUseCase(hotelRepositoryMock)
    }

    @Test
    fun `retrieve all hotels from data source`() {
        runBlocking {
            // When
            hotelsUseCase()

            // Verify
            verify(hotelRepositoryMock).retrieveHotels()
        }
    }
}