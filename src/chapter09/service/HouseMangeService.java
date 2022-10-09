package chapter09.service;

import chapter09.model.House;

public class HouseMangeService {
    House[] houses;
    int houseNum = 0;
    int id = 0;

    public HouseMangeService(int ListLength) {
        this.houses = new House[ListLength];
    }

    public boolean addHouse(House house) {
        if (houseNum == houses.length) {
            System.out.println("房屋列表已满，不能再进行添加");
            return false;
        }
         else {
             house.setId(++id);
            houses[houseNum++] = house;
            return true;
        }
    }

    public boolean deleteHouse(int id) {
        int index = -1;
        for (int i = 0; i < houseNum; i++) {
            if (id == houses[i].getId())
                index = i;
        }
        if (index == -1){
            System.out.println("待删除房屋编号不存在");
            return false;
        }
        for (int i = index; i < houseNum - 1; i++) {
            houses[i] = houses[i + 1];
        }
        houses[--houseNum] = null;
        return true;
    }

    public House findHouse(int id) {
        for (int i = 0; i < houseNum; i++) {
            if (id == houses[i].getId())
                return houses[i];
        }
        return null;
    }

    public House[] getHouseList() {
        return houses;
    }
}
