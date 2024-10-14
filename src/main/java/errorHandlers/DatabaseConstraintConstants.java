package errorHandlers;


import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DatabaseConstraintConstants {
    private static final Map<String, ErrorCode> EXCEPTION_MAP ;
    static {
        Map<String, ErrorCode> result = new HashMap<String, ErrorCode>();      
        result.put("vehicle_acctID", ErrorCode.ERR1111);
        EXCEPTION_MAP = Collections.unmodifiableMap(result);
    }
    

    // Finds the constraint based on name.
    // NOTE: This used to be a simple map lookup. Now we iterate over the keys so that we can
    //       accept a constraintName with optional table-name.
    public static ErrorCode findConstraintError(String constraintFromDbError) {
        Pattern pattern = Pattern.compile("^(.+\\.)?(.+)$"); // matches [table-name.]constraint-name
        Matcher m = pattern.matcher(constraintFromDbError);
        if (!m.matches()) {
            // the value doesn't even match the pattern
            return null;
        }
        String constraintName = m.group(2);
        for (Entry<String, ErrorCode> entry : EXCEPTION_MAP.entrySet()) {
            if (entry.getKey().equals(constraintName)) {
                return entry.getValue();
            }
        }
        return null;
    }
}
