package com.ssafy.happyhouse.util;

import java.util.LinkedList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import com.ssafy.happyhouse.model.dto.HouseDeal;

/**
 *  AptRentHistory.xml 파일에서 아파트 전월세 정보를 읽어 파싱하는 핸들러 클래스 
 */
public class TouristSpotSAXHandler extends DefaultHandler {
	/**아파트 거래 정보를 담는다 */
	private List<HouseDeal> houses;
	/**파상힌 아파트 거래 정보*/
	private HouseDeal house;
	/**태그 바디 정보를 임시로 저장*/
	private String temp;
	public TouristSpotSAXHandler(){
		houses = new LinkedList<HouseDeal>();
	}
	public void startElement(String uri, String localName
			                           , String qName, Attributes att ){
		if(qName.equals("person")){
			house = new HouseDeal(HouseSaxParser.no++);
			//house.setType(HouseDeal.APT_RENT);
			houses.add(house);
		}
	}
	public void endElement(String uri, String localName, String qName){
		if(qName.equals("last-name")) { 
			house.setTouristSpot(temp.trim());
		}else if(qName.equals("country")) { 
			house.setDong2(temp.trim());
		}
	}
	public void characters(char[]ch, int start, int length){
		temp = new String(ch, start, length);
	}
	public List<HouseDeal> getHouses() {
		return houses;
	}
	public void setHouses(List<HouseDeal> houses) {
		this.houses = houses;
	}
}





