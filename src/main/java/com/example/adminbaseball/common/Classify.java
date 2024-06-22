package com.example.adminbaseball.common;

public class Classify {

    public String TransferPaymentMethod(String paymentMethod) {
        String paymentMethodKor="";

        switch (paymentMethod) {
            case "m":
                paymentMethodKor ="마일리지";
                break;
            case "c":
                paymentMethodKor = "카드";
                break;

            case "p":
                paymentMethodKor = "모바일";
                break;
        }
        return paymentMethodKor;
    }

    public String TransferReservationState(String reservationState) {
         String reservationStateKor="";

        switch (reservationState) {
            case "a":
                reservationStateKor ="예매완료";
                break;
            case "b":
                reservationStateKor = "예매";
                break;

            case "c":
                reservationStateKor = "예매취소";
                break;
        }
        return reservationStateKor;
    }


}
