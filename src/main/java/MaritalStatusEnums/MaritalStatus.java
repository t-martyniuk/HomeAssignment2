package MaritalStatusEnums;


import lombok.Getter;

@Getter
public enum MaritalStatus {
    MARRIED(1, "נָשׂוּי"), SINGLE(2, "יחיד"), DIVORCED(3, "גרושה"), WIDOW(4,"האלמנה");

    private final int dbCode;
    private final String hebrewDesc;

    MaritalStatus(int dbCode, String hebrewDesc) {
        this.dbCode = dbCode;
        this.hebrewDesc = hebrewDesc;
    }


    public static MaritalStatus findByDbCode(int dbCode) {
        MaritalStatus[] statuses = values();
        for (MaritalStatus status : statuses) {
            if (status.dbCode == dbCode) {
                return status;
            }
        }
        throw new RuntimeException(dbCode + " not supported");
    }

    @Override
    public String toString() {
        return hebrewDesc;
    }
}
