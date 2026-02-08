// i am not familir with TS so i used what more easy to me insted of enum class

export interface Card {
  name: string;
  date: string;
  leader: string;
}

export const CardOrganizer: Card[] = [
  { name: "BATTLE_OF_BADR", date: "2 AH", leader: "Prophet Muhammad" },
  { name: "BATTLE_OF_Mutta", date: "8 AH", leader: "Zayd ibn Harithah" },
  { name: "BATTLE_OF_QADISYYA", date: "15 AH", leader: "Saad ibn Abi Waqqas" },
  { name: "BATTLE_OF_YARMUK", date: "15 AH", leader: "Khalid ibn al-Walid" },
  { name: "BATTLE_OF_Nahavand", date: "21 AH", leader: "Al-Nuuman ibn Muqarrin" }
];
