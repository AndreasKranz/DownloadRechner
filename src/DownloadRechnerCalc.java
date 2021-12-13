public class DownloadRechnerCalc {

    //Attribute
    private double DataSize;
    private double DLoadSpeed;
    private double ULoadSpeed;
    private int DLoadTimeSec;
    private int DLoadTimeMin;
    private int DLoadTimeHours;
    private int ULoadTimeSec;
    private int ULoadTimeMin;
    private int ULoadTimeHours;
    private double DataSizeType;      //ID für KB/MB/GB oder Kbit/Mbit/Gbit
    private double SpeedSizeType;      //ID für KBs/MBs/GBs oder Kbits/Mbits/Gbits
    //AttributeFIN

    public DownloadRechnerCalc(double DataSize, double DLoadSpeed,double ULoadSpeed, double SpeedSizeType, double DataSizeType) {
        this.DataSizeType = DataSizeType;
        this.SpeedSizeType = SpeedSizeType;
        this.DataSize = DataSize;
        this.DLoadSpeed = DLoadSpeed;
        this.ULoadSpeed = ULoadSpeed;
    }

    public DownloadRechnerCalc() {
        this.DataSizeType = 3.0;
        this.SpeedSizeType = 5.0;
        this.DLoadSpeed = 100.0;
        this.ULoadSpeed = 40000.0;
    }

    //Methoden

    double DataSizeKB = 0;
    double DLoadSpeedKB = 0;
    double ULoadSpeedKB = 0;



    public void calcLoadTime() {
        if (this.DataSize < 0) {
            this.DataSize = (-1 * DataSize);
        }
        if (this.DLoadSpeed < 0) {
            this.DLoadSpeed = (-1 * DLoadSpeed);
        }
        if (this.ULoadSpeed < 0) {
            this.ULoadSpeed = (-1 * ULoadSpeed);
        }

        if (this.DataSize != 0 || this.DLoadSpeed != 0) {
            this.DLoadTimeSec = 0;
            this.DLoadTimeMin = 0;
            this.DLoadTimeHours = 0;
            switch ((int)DataSizeType) {
                case 1:
                    DataSizeKB = this.DataSize;   //KByte inserted
                    break;
                case 2:
                    DataSizeKB = (1000.0 * this.DataSize);    //MByte inserted
                    break;
                case 3:
                    DataSizeKB = (1000000.0 * this.DataSize);     //GByte inserted
                    break;
                case 4:
                    DataSizeKB = (1000000000.0 * this.DataSize);      //TByte inserted
                    break;
                /*case 5:
                    DataSizeKB = (0.125 * this.DataSize);   //KBit inserted
                    break;
                case 6:
                    DataSizeKB = (125 * this.DataSize);    //MBit inserted
                    break;
                case 7:
                    DataSizeKB = (125000 * this.DataSize);     //GBit inserted
                    break;
                case 8:
                    DataSizeKB = (125000000 * this.DataSize);      //TBit inserted
                    break;*/
            }

            switch ((int)SpeedSizeType) {
                case 1:
                    DLoadSpeedKB = this.DLoadSpeed;     //KBytes inserted
                    ULoadSpeedKB = this.ULoadSpeed;
                    break;
                case 2:
                    DLoadSpeedKB = (1000.0 * this.DLoadSpeed);      //Mbytes inserted
                    ULoadSpeedKB = (1000.0 * this.ULoadSpeed);
                    break;
                case 3:
                    DLoadSpeedKB = (1000000.0 * this.DLoadSpeed);       //GBytes inserted
                    ULoadSpeedKB = (1000000.0 * this.ULoadSpeed);
                    break;
                case 4:
                    DLoadSpeedKB = (0.125 * this.DLoadSpeed);   //KBits inserted
                    ULoadSpeedKB = (0.125 * this.ULoadSpeed);
                    break;
                case 5:
                    DLoadSpeedKB = (125.0 * this.DLoadSpeed);    //MBits inserted
                    ULoadSpeedKB = (125 * this.ULoadSpeed);
                    break;
                case 6:
                    DLoadSpeedKB = (125000.0 * this.DLoadSpeed);     //GBits inserted
                    ULoadSpeedKB = (125000.0 * this.ULoadSpeed);
                    break;
            }

            this.DLoadTimeSec = (int) (this.DataSizeKB / this.DLoadSpeedKB);

            if (DLoadTimeSec >= 60) {
                this.DLoadTimeMin = (DLoadTimeSec / 60);
                this.DLoadTimeSec = (DLoadTimeSec % 60);
                if (DLoadTimeMin >= 60) {
                    this.DLoadTimeHours = (DLoadTimeMin / 60);
                    this.DLoadTimeMin = (DLoadTimeMin % 60);
                }
            }

            this.ULoadTimeSec = (int) (this.DataSizeKB / this.ULoadSpeedKB);

            if (ULoadTimeSec >= 60) {
                this.ULoadTimeMin = (ULoadTimeSec / 60);
                this.ULoadTimeSec = (ULoadTimeSec % 60);
                if (ULoadTimeMin >= 60) {
                    this.ULoadTimeHours = (ULoadTimeMin / 60);
                    this.ULoadTimeMin = (ULoadTimeMin % 60);
                }
            }
        } else {
            System.out.println("Down-/Uploadgeschwindigkeit und Dateigröße müssen größer als '0' sein!");
        }
    }

    public double getDataSizeType() {
        return DataSizeType;
    }

    public void setDataSizeType(int dataSizeType) {
        DataSizeType = dataSizeType;
    }

    public double getSpeedSizeType() {
        return SpeedSizeType;
    }

    public void setSpeedSizeType(int speedSizeType) {
        SpeedSizeType = speedSizeType;
    }

    public double getDLoadSpeed() {
        return DLoadSpeed;
    }

    public double getDataSize() {
        return DataSize;
    }

    public int getDLoadTimeSec() {
        return DLoadTimeSec;
    }

    public int getDLoadTimeMin() {
        return DLoadTimeMin;
    }

    public int getDLoadTimeHours() {
        return DLoadTimeHours;
    }

    public void setDataSize(double dataSize) {
        this.DataSize = dataSize;
    }

    public void setDLoadSpeed(double DLoadSpeed) {
        this.DLoadSpeed = DLoadSpeed;
    }

    public void setDLoadTimeSec(int DLoadTimeSec) {
        this.DLoadTimeSec = DLoadTimeSec;
    }

    public void setDLoadTimeMin(int DLoadTimeMin) {
        this.DLoadTimeMin = DLoadTimeMin;
    }

    public void setDLoadTimeHours(int DLoadTimeHours) {
        this.DLoadTimeHours = DLoadTimeHours;
    }

    public double getULoadSpeed() {
        return ULoadSpeed;
    }

    public void setULoadSpeed(double ULoadSpeed) {
        this.ULoadSpeed = ULoadSpeed;
    }

    public int getULoadTimeSec() {
        return ULoadTimeSec;
    }

    public void setULoadTimeSec(int ULoadTimeSec) {
        this.ULoadTimeSec = ULoadTimeSec;
    }

    public int getULoadTimeMin() {
        return ULoadTimeMin;
    }

    public void setULoadTimeMin(int ULoadTimeMin) {
        this.ULoadTimeMin = ULoadTimeMin;
    }

    public int getULoadTimeHours() {
        return ULoadTimeHours;
    }

    public void setULoadTimeHours(int ULoadTimeHours) {
        this.ULoadTimeHours = ULoadTimeHours;
    }
}
