package Game;


import Card.Card;

//TODO: To be implemented in week 2
public class ComboType {
    private String type;
    private boolean isValid;

    public ComboType(Card[] input) {
        if (isSingle(input)) {
            type = "Single";
            isValid = true;
        } else if (isPair(input)) {
            type = "Pair";
            isValid = true;
        } else {
            type = "invalid";
            isValid = false;
        }
    }

    /**
     *
     * @param input
     * @return
     */
    public boolean isSingle(Card[] input) {
        if (input.length == 1) {
            return true;
        }
        return false;
    }

    public boolean isPair(Card[] input) {
        if (input.length == 2) {
            return input[0].getFacialValue() == input[1].getFacialValue();
        }
        return false;
    }

    public String getType() {
        return type;
    }

    public boolean isValid() {
        return isValid;
    }
}
