package com.wang.lambdaexpresion;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Shipment {
	double weight = 0;
	
	public Shipment(double weight){
		this.weight = weight;
	}
	
	public double calculateWeight() {
		return weight;
	}

	public List<Double> calculateOnShipments(List<Shipment> list, Function<Shipment, Double> f) {
		List<Double> results = new ArrayList<>();
		for (Shipment s : list) {
			results.add(f.apply(s));
		}
		return results;
	}
	
	public static void main(String[] args){
		List<Shipment> shipmentList = new ArrayList<Shipment>();
		Shipment shipment = new Shipment(20);
		shipmentList.add(shipment);
		shipment = new Shipment(30);
		shipmentList.add(shipment);
		
		// 定义anonymous Function使用Shipment作为input， 并且返回double。
		List<Double> list = shipment.calculateOnShipments(shipmentList, new Function<Shipment, Double>(){
			public Double apply(Shipment s){
				return s.calculateWeight();
			}
		});
		Shipment.print(list);
		// do same thing by simpler way of using lambda expression, readability is low, don't know what is c. 
		// you need go back to check the definition of Shipment.calculateOnShipments() method to know what is c.
		list = shipment.calculateOnShipments(shipmentList, c -> c.calculateWeight());
		Shipment.print(list);
		
		// do same thing by using function reference, better readability.
		list = shipment.calculateOnShipments(shipmentList, Shipment::calculateWeight);
		Shipment.print(list);
	}
	
	public static void print(List<Double> list){
		for(Double d : list){
			System.out.println(d);
		}		
		System.out.println();
	}
}

