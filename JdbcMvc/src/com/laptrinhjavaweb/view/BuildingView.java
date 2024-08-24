package com.laptrinhjavaweb.view;

import java.util.List;
import java.util.Scanner;

import com.laptrinhjavaweb.controller.BuildingController;
import com.laptrinhjavaweb.model.BuildingModel;

public class BuildingView {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter building name :  ");
		String buildingName = scanner.nextLine();
		
		System.out.print("Enter numberOfBasement :  ");
		String numberOfBasement = scanner.nextLine();
		
		// TAO 1 DOI TUONG BUILDING MODEL DE CHUA
		BuildingModel buildingModel = new BuildingModel();
		
		buildingModel.setName(buildingName);
		//set and ép kiểu sang kiểu Int --> Nhận giá trị Int trong BuildingModel Class
		buildingModel.setNumberOfBasements(Integer.parseInt(numberOfBasement));
		
		BuildingController buildingController = new BuildingController();
		List<BuildingModel> rs = buildingController.findAll(buildingModel);
		
		for(BuildingModel item: rs){
			System.out.println("Ten toa nha : "+ item.getName() + "So tang ham: " + item.getNumberOfBasements());
			
		}
		
	}
}
