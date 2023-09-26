import java.util.Arrays;
public class InputValidation {

    /**
     * MAX and MIN amount RANGE excluding them
     */
    final int MIN = 0, MAX = 1000;
    private  enum validCategory{
        FOOD, TRAVEL, BILLS, ENTERTAINMENT, OTHER
    }
    /**
     * This method checks validity of amount
     * @param amount amount that is to be validated
     * @return boolean true if the amount is valid else false
     */
    public boolean validateAmount(double amount){
        return MIN < amount && amount < MAX;
    }

    /**
     * This method checks validity of category
     * @param category category that is to be validated
     * @return boolean true if the category is valid else false
     */
    public boolean validateCategory(String category){
        return Arrays.stream(validCategory.values()).anyMatch(e -> e.name().equalsIgnoreCase(category));

    }
    
}
