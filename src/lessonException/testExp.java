package lessonException;

public class testExp {
    public static void main(String[] args) throws CustomException {
        try {
        throw new RTE("kokoko");
        }
         catch (RTE e) {
            try {
                throw new RTE("sdf", e);
            }
            catch (RTE k) {
                System.out.println("1");
                System.out.println("sdf " + k.getCause());
            }
        }

        throw new RTE("oioioi");  // ничего обрабатывать не обязательно

    }
}

class RTE extends RuntimeException {
    public RTE(String mess){
        super(mess);
    }
    public RTE(String mess, Throwable cause){
        super(mess, cause);
    }
}
