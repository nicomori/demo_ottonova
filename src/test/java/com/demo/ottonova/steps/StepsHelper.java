package com.demo.ottonova.steps;

import java.util.List;

public class StepsHelper {

	public void showList(List listOfTitlesToSendMessage) {
		System.out.println("content size: " + listOfTitlesToSendMessage.size());
		for (int i = 0; i < listOfTitlesToSendMessage.size(); i++) {
			System.out.println(listOfTitlesToSendMessage.get(i));
		}
		System.out.println("finish read the list.");
	}

}
