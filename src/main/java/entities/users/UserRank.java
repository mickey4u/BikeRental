package entities.users;

/**
 * Ranks achieved by users on the platform
 */
public enum UserRank {
    // no discount on bike rentals
    BASIC ,
    // 2 percent discount on bike rentals during weekdays, awarded after 10 rentals
    SILVER,
    // 5 percent discount on bike rentals during weekdays, awarded after 20 rentals
    GOLD
}
