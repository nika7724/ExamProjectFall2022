package com.example.examprojectfall2022.service;

import com.example.examprojectfall2022.model.Delivery;
import com.example.examprojectfall2022.repository.DeliveryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)//use Mockito
class DeliveryServiceTest {

    @Mock
    private DeliveryService deliveryService;
    @Mock
    private DeliveryRepository deliveryRepository;

    private Delivery delivery;
    private Long id;

    @BeforeEach
    void setUp() {
        deliveryService = new DeliveryService(deliveryRepository);
        delivery = new Delivery(LocalDate.of(2022, 12, 19),
                "wahrehouse1", "CopenhagenS");

    }

    @Test
    void getAllDelivery() {
        deliveryService.getAllDelivery();
        Mockito.verify(deliveryRepository).findAll();
    }

    @Test
    void getDeliveryById() {
        deliveryService.getDeliveryById(id);
        Mockito.verify(deliveryRepository).findById(id);
    }

    @Test
    void createDelivery() {
        deliveryService.createDelivery(delivery);
        ArgumentCaptor<Delivery> DeliveryArgumentCaptor = ArgumentCaptor.forClass(Delivery.class);
        verify(deliveryRepository).save(DeliveryArgumentCaptor.capture());
        Delivery capturedDelivery = DeliveryArgumentCaptor.getValue();
        assertThat(capturedDelivery).isEqualTo(delivery);
    }

    @Test
    void deleteDeliveryById() {
        deliveryService.deleteDeliveryById(id);
        Mockito.verify(deliveryRepository).deleteById(id);
    }

    @Test
    void editDelivery() {
        //given precondition or setup
        delivery.setDeliveryDate(LocalDate.of(2022, 12, 23));
        delivery.setWarehouse("warehouse2");
        delivery.setDestination("CopenhagenW");

        Mockito.when(deliveryRepository.findById(id)).thenReturn(Optional.ofNullable(delivery));
        Mockito.when(deliveryRepository.save(delivery)).thenReturn(delivery);
//action or the behaviour that we are going to test
        Delivery editDelivery = deliveryService.editDelivery(id, delivery);

//verify the output
        assertThat(editDelivery.getDeliveryDate()).isEqualTo(LocalDate.of(2022, 12, 23));
        assertThat(editDelivery.getWarehouse()).isEqualTo("warehouse2");
        assertThat(editDelivery.getDestination()).isEqualTo("CopenhagenW");
    }
}