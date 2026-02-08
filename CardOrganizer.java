public enum CardOrganizer {
    // Constant varibles 
    BATTLE_OF_BADR("2 AH", "Prophet Muhammad"),
    BATTLE_OF_Mutta("8 AH", "Zayd ibn Harithah"),
    BATTLE_OF_QADISYYA("15 AH", "Saad ibn Abi Waqqas"),
    BATTLE_OF_YARMUK("15 AH", "Khalid ibn al-Walid"),
    BATTLE_OF_Nahavand("21 AH", "Al-Nuuman ibn Muqarrin");
    
    // I did it like slides in Lecture three
    private final String year;
    private final String leader;

    CardOrganizer(String year, String leader) {
        this.year = year;
        this.leader = leader;
    }

    public String getDate() {
        return year;
    }

    public String getLeader() {
        return leader;
    }
    
    
}
