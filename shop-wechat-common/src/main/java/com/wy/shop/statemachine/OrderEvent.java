package com.wy.shop.statemachine;

public enum OrderEvent {

    /** 用户取消支付 */
    USER_CANCELLED(){
        @Override
        public void changeState() {

        }
    },
    /** 系统取消订单 */
    SYSTEM_CANCELLED(){
        @Override
        public void changeState() {

        }
    },
    PAY() {
        @Override
        public void changeState() {

        }
    },
    /** 取消订单 */
    CANCELLED_ORDER(){
        @Override
        public void changeState() {

        }
    },
    /** 退款 */
    REFUND() {
        @Override
        public void changeState() {

        }
    },

    /** 审核退款 */
    CHECK_REFUND() {
        @Override
        public void changeState() {

        }
    },

    /** 发货 */
    SHIP() {
        @Override
        public void changeState() {

        }
    },
    /** 用户收货 */
    USER_RECEIVE() {
        @Override
        public void changeState() {

        }
    },
     /** 系统收货 */
    SYSTEM_RECEIVE() {
         @Override
         public void changeState() {

         }
     };



    public abstract void changeState();



}
