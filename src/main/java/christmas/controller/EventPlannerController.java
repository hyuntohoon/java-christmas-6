package christmas.controller;

import christmas.model.EventPlanner;
import christmas.view.InputView;
import christmas.view.OutputView;

public class EventPlannerController {

    public void run() {
        OutputView.displayWelcomeMessage();
        int orderDay = InputView.readOrderDate();
        String orderMenuString = InputView.readOrderMenu();

        EventPlanner eventPlanner = new EventPlanner(orderDay, orderMenuString);

        OutputView.displayOrderDetails(eventPlanner.getOrderDetails());
        OutputView.displayTotalBeforeDiscount(eventPlanner.calculateTotalBeforeDiscount());
        OutputView.displayGiftItemDetails(eventPlanner.getGiftItemDetails());

        String discountDetails = eventPlanner.getDiscountDetails();
        OutputView.displayDiscountDetails(discountDetails);
        OutputView.displayTotalDiscount(eventPlanner.calculateTotalDiscount());

        OutputView.displayTotalAfterDiscount(eventPlanner.calculateTotalAfterDiscount());
        OutputView.displayBadgeDetails(eventPlanner.getEventBadgeDetails());

    }
}
