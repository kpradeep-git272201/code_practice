package array;

import java.util.*;

public class AsyncExample {

    public static void main(String[] args) {
        System.out.println("Main code started...");
        new Thread(() -> {
            try {

                List<PlanYearWiseLgdDetails> list = getPlanYearWiseLgdDetails(2025);
                for (PlanYearWiseLgdDetails l : list) {
                    setPdpSelfAssessment(
                            2025,
                            l.getSlc(),
                            l.getLocalBodyCode(),
                            l.getLocalBodyTypeCode()
                    );
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
        System.out.println("Main code finished (return).");
    }


    static List<PlanYearWiseLgdDetails> getPlanYearWiseLgdDetails(int fnclYr) {
        return Arrays.asList(
                new PlanYearWiseLgdDetails(1, 101, 11),
                new PlanYearWiseLgdDetails(2, 202, 22),
                new PlanYearWiseLgdDetails(3, 303, 33)
        );
    }

    static void setPdpSelfAssessment(int year, int slc, int code, int typeCode) {
        System.out.println("Processing: year=" + year +
                ", slc=" + slc +
                ", code=" + code +
                ", typeCode=" + typeCode);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

// Example entity
class PlanYearWiseLgdDetails {
    private int slc;
    private int localBodyCode;
    private int localBodyTypeCode;

    public PlanYearWiseLgdDetails(int slc, int localBodyCode, int localBodyTypeCode) {
        this.slc = slc;
        this.localBodyCode = localBodyCode;
        this.localBodyTypeCode = localBodyTypeCode;
    }

    public int getSlc() { return slc; }
    public int getLocalBodyCode() { return localBodyCode; }
    public int getLocalBodyTypeCode() { return localBodyTypeCode; }
}
