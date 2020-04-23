package Entity;
/*
* 户主实体类
*
* */
public class HouseHolder {
   private int houseHolderNumber;       //户号
   private String houseHoldername;      //户主名
   private int houseHolderId;           //户主身份证号

   private double waterBalance;         //水费余额
   private double electricityBalance;   //电费余额
   //Date date = ; //入住日期 先不做


    public HouseHolder(String houseHoldername, int houseHolderId, double waterBalance, double electricityBalance) {
        this.houseHoldername = houseHoldername;
        this.houseHolderId = houseHolderId;
        this.waterBalance = waterBalance;
        this.electricityBalance = electricityBalance;
    }

    public HouseHolder(int houseHolderNumber, String houseHoldername, int houseHolderId) {
        this.houseHolderNumber = houseHolderNumber;
        this.houseHoldername = houseHoldername;
        this.houseHolderId = houseHolderId;
    }

    public HouseHolder(int houseHolderNumber, String houseHoldername, int houseHolderId, double waterBalance, double electricityBalance) {
        this.houseHolderNumber = houseHolderNumber;
        this.houseHoldername = houseHoldername;
        this.houseHolderId = houseHolderId;
        this.waterBalance = waterBalance;
        this.electricityBalance = electricityBalance;
    }


    public int getHouseHolderNumber() {
        return houseHolderNumber;
    }

    public void setHouseHolderNumber(int houseHolderNumber) {
        this.houseHolderNumber = houseHolderNumber;
    }

    public String getHouseHoldername() {
        return houseHoldername;
    }

    public void setHouseHoldername(String houseHoldername) {
        this.houseHoldername = houseHoldername;
    }

    public int getHouseHolderId() {
        return houseHolderId;
    }

    public void setHouseHolderId(int houseHolderId) {
        this.houseHolderId = houseHolderId;
    }

    public double getWaterBalance() {
        return waterBalance;
    }

    public void setWaterBalance(double waterBalance) {
        this.waterBalance = waterBalance;
    }

    public double getElectricityBalance() {
        return electricityBalance;
    }

    public void setElectricityBalance(double electricityBalance) {
        this.electricityBalance = electricityBalance;
    }
}
