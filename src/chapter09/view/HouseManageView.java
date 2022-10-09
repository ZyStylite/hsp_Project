package chapter09.view;


import chapter09.model.House;
import chapter09.service.HouseMangeService;
import chapter09.utils.Utility;



public class HouseManageView {
    boolean isExit = false;
    int key;
    HouseMangeService hms = new HouseMangeService(10);

    public void mainVenue() {
        do {

            System.out.println("============房屋管理系统============");
            System.out.println("\t\t\t1 新增房屋");
            System.out.println("\t\t\t2 查找房屋");
            System.out.println("\t\t\t3 删除房屋");
            System.out.println("\t\t\t4 修改房屋信息");
            System.out.println("\t\t\t5 房屋列表");
            System.out.println("\t\t\t6 退出系统");
            System.out.print("请选择（1-6）：");
            key = Utility.readInt();
            switch (key) {
                case 1:
                    System.out.println("新增房屋");
                    addHouse();
                    break;
                case 2:
                    System.out.println("查找房屋");
                    findHouse();
                    break;
                case 3:
                    System.out.println("删除房屋");
                    deleteHouse();
                    break;
                case 4:
                    System.out.println("修改房屋信息");
                    updateHouse();
                    break;
                case 5:
                    System.out.println("房屋列表");
                    showHouseList();
                    break;
                case 6:
                    exit();
                    break;
                default:
                    System.out.println("输入错误，请重新输入");
            }
        } while (!isExit);

    }

    public void addHouse() {
        System.out.print("房主: ");
        String owner = Utility.readString(8);
        System.out.print("电话: ");
        String phone = Utility.readString(12);
        System.out.print("地址: ");
        String address = Utility.readString(16);
        System.out.print("月租: ");
        int rent = Utility.readInt();
        System.out.print("房屋状态: ");
        String state = Utility.readString(3);
        House house = new House(owner, phone, address, rent, state);
        if (hms.addHouse(house))
            System.out.println("房屋添加成功");
        else
            System.out.println("房屋添加失败");
    }

    public void deleteHouse() {
        System.out.print("请输入待删除房屋的编号(-1退出):");
        int id = Utility.readInt();
        if (id == -1){
            System.out.println("已放弃删除");
            return;
        }
        char c = Utility.readConfirmSelection();
        if (c == 'Y') {
            if (hms.deleteHouse(id))
                System.out.println("编号为" + id + "房屋删除成功");
            else
                System.out.println("房屋删除失败");
        }
        else
            System.out.println("已放弃删除");
    }

    public void findHouse() {
        System.out.print("请输入所查找房屋的编号：");
        int id = Utility.readInt();
        House house = hms.findHouse(id);
        if (house != null) {
            System.out.println("编号\t房主\t电话\t\t地址\t月租\t房屋状态");
            System.out.println(house);
        }
        else
            System.out.println("所查找房屋的编号不存在");

    }

    public void updateHouse() {
        System.out.print("请输入待修改信息房屋的编号：");
        int id = Utility.readInt();
        House house = hms.findHouse(id);
        if (house == null) {
            System.out.println("待修改信息房屋的编号不存在");
            return;
        }
        System.out.print("姓名(" + house.getOwner() + "): ");
        String owner = Utility.readString(8, "");
        if (!"".equals(owner)) {
            house.setOwner(owner);
        }
        System.out.print("电话(" + house.getPhone() + "):");
        String phone = Utility.readString(12, "");
        if (!"".equals(phone)) {
            house.setPhone(phone);
        }
        System.out.print("地址(" + house.getAddress() + "): ");
        String address = Utility.readString(18, "");
        if (!"".equals(address)) {
            house.setAddress(address);
        }
        System.out.print("租金(" + house.getRent() + "):");
        int rent = Utility.readInt(-1);
        if (rent != -1) {
            house.setRent(rent);
        }
        System.out.print("状态(" + house.getState() + "):");
        String state = Utility.readString(3, "");
        if (!"".equals(state)) {
            house.setState(state);
        }
        System.out.println("房屋信息修改成功");
    }

    public void showHouseList() {
        House[] houses = hms.getHouseList();
        System.out.println("编号\t房主\t电话\t\t地址\t月租\t房屋状态");
        for (House house : houses) {
            if (house == null)
                return;
            System.out.println(house);
        }
    }

    public void exit() {
        char c = Utility.readConfirmSelection();
        if (c == 'Y')
            this.isExit = true;
        System.out.println("退出了房屋管理系统");
    }
}
