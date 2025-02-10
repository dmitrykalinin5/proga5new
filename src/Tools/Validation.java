package Tools;

public interface Validation {
    boolean validate();

    default void validateOrThrow() {
        if (!validate()) {
            throw new IllegalStateException(getErrorMessage());
        }
    }

    String getErrorMessage();
}