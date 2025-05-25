// #Input checks like empty string, number format, etc.
public class Validation {
    public static boolean isValidTitle(String title) {
        return (title != null && !title.trim().isEmpty());
    }

    public static boolean isValidDate(String date) {
        // Simple check (format should be dd-mm-yyyy or similar)
        return date.matches("\\d{2}-\\d{2}-\\d{4}");
    }
}
