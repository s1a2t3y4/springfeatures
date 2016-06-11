 
package com.satya.springfeatures.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.TimeZone;
 

public final class Utils {
    /** class for formatting and parsing dates in a locale-sensitive manner. */
    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat();

    /**
     * Convert input string into properties. Returns null if cannot parse input
     * string. Reruns empty Properties instance if string is empty.
     *
     * @param input
     *            the comma delimited string such as: abc=value1, xyz=value2
     * @return the properties
     */
    public static Properties str2Properties(String input) {
        Properties properties = new Properties();

        if (isNothing(input)) {
            return properties;
        }

        input = input.trim();

        if (input.charAt(0) == '{') {
            input = input.substring(1);
        }

        if (input.charAt(input.length() - 1) == '}') {
            input = input.substring(0, input.length() - 1);
        }

        try {
            properties.load(new StringReader(input.replaceAll(",", "\n")));

            return properties;
        } catch (Exception ex) {
            return null;
        }
    }

    /**
     * Returns true if object is null, or if object.toString().trim().length()
     * == 0.
     * 
     * @param object
     *            the object to check
     * 
     * @return true, if object is 'nothing'
     */
    public static boolean isNothing(Object object) {
        return (object == null || object.toString().trim().length() == 0);
    }

    /**
     * Converts object to string. Returns either <code>o.toString()</code> or ""
     * if <code>o == null || o.toString() == null</code>.
     *
     * @param o
     *            the input object
     * @return the string
     */
    public static String makeString(Object o) {
        if (o == null)
            return "";

        String ret = o.toString();

        return ret != null ? ret : "";
    }

    /**
     * Checks if string belongs to separated list of strings.
     *
     * @param list
     *            the list
     * @param str
     *            the string to check
     * @param separator
     *            the separator
     * @param ignoreCase
     *            if true ignore the character case
     * @return true, if string belongs to separated list of strings
     */
    public static boolean str2BelongsTo(String list, String str, String separator, boolean ignoreCase) {
        String[] tokens = list.split(separator);

        for (String token : tokens) {
            if ((ignoreCase && token.trim().equalsIgnoreCase(str.trim()) || token.trim().equals(str.trim()))) {
                return true;
            }
        }

        return false;

    }

    /**
     * Capitalizes first character of the string.<br>
     * <br>
     *
     * <b>Examples:</b><br>
     *
     * abc->Abc<br>
     * 1bc->1bc<br>
     *
     * @param value
     *            the input string
     * @return the string with capitalized first character
     */
    public static String capFirstChar(String value) {
        if (Utils.isNothing(value)) {
            return value;
        }

        if (value.length() == 1) {
            return value.toUpperCase();
        }

        return value.substring(0, 1).toUpperCase() + value.substring(1, value.length());
    }
    
    /**
     * Sets time to midnight.
     *
     * @param date
     *            the date
     * @return date
     */
    public static Date setTimeToMidnight(Date date)
    {
        Calendar calendar = Calendar.getInstance();
        
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        
        return calendar.getTime();
    }
    
    /**
     * Sets the date to beginning of time.
     *
     * @param date the date
     * @return the date
     */
    public static Date setDateToBeginningOfTime(Date date)
    {
        Calendar calendar = Calendar.getInstance();
        
        calendar.setTime(date);
        calendar.set(Calendar.YEAR, 0);
        calendar.set(Calendar.MONTH, 0);
        calendar.set(Calendar.DATE, 0);
        
        return calendar.getTime();
    }
    
    

    /**
     * Compares two objects.
     * 
     * @param o1
     *            the first object to compare
     * @param o2
     *            the second object to compare
     * 
     * @return true, if objects are equal
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    public static int compare(Object o1, Object o2) {
        if (o1 == null && o2 == null) {
            return 0;
        }

        if (o1 != null && o2 == null) {
            return 1;
        }

        if (o1 == null && o2 != null) {
            return -1;
        }

        if (!o2.getClass().isInstance(o1)) {
            return 1;
        }

        if (o1 instanceof Comparable) {
            return ((Comparable) o1).compareTo(o2);
        }

        return o1.toString().compareTo(o2.toString());
    }

    /**
     * Converts Date to String.
     *
     * <p>
     * Note that since a Timestamp inherits from java.util.Date, this method
     * will also work on Timestamps.
     * </p>
     *
     * <p>
     * Known limitation: milliseconds will print as 0 if date is a
     * <code>java.sql.Timestamp</code> object, because of inheritance weirdness
     * between it and <code>java.util.Date</code>. This is a reasonably easy
     * fix, not implemented because there's no need and it would marginally slow
     * the code.
     * </p>
     *
     * <p>
     * For example, to display a date in the format "02/13/2001 21:45:12", use
     * <code>Utils.dateToString(myDate, "MM/dd/yyyy HH:mm:ss");</code>
     * </p>
     *
     * @param date
     *            The date to be formatted.
     * @param format
     *            The format being applied to this date. Specifications can be
     *            found in {@link java.text.SimpleDateFormat}. Alternately, you
     *            can use one of the class variables.
     *
     * @return The date as a string, in the appropriate format.
     *
     * @see java.sql.Timestamp
     */
    public static String date2Str(Date date, String format) {
        synchronized (simpleDateFormat) {
            if (simpleDateFormat.getCalendar().getTimeZone() == null)
                simpleDateFormat.getCalendar().setTimeZone(getDefaultTimeZone());

            simpleDateFormat.applyPattern(format);
            return date != null ? simpleDateFormat.format(date) : "";
        }
    }

    /**
     * Converts string to date using <code>format</code> string. If there is an
     * error or input value is null returns <code>def</code>.
     *
     * @param str
     *            the input string
     * @param def
     *            the default value
     * @param format
     *            The format being applied to the formatter. Specifications can
     *            be found in {@link java.text.SimpleDateFormat}.
     * @return the Date
     */
    public static Date str2Date(String str, Date def, String format) {
        if (str == null)
            return def;

        try {
            DateFormat formatter = new SimpleDateFormat(format);
            return formatter.parse(str);
        } catch (ParseException ex) {
            return def;
        }
    }

    /**
     * Gets the default time zone.
     *
     * @return the default time zone
     */
    public static TimeZone getDefaultTimeZone() {
        return TimeZone.getDefault();
    }

    /**
     * Converts stack trace from the given Throwable to the string.
     *
     * @param e
     *            the Throwable
     *
     * @return the stack trace as a string
     */
    public static String getStackTraceAsString(Throwable e) {
        if (e == null)
            return "";

        ByteArrayOutputStream ostr = new ByteArrayOutputStream();
        e.printStackTrace(new PrintStream(ostr));
        return ostr.toString();
    }

    /**
     * Creates string from the input stream.
     *
     * @param is
     *            the input stream
     * @return the string
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    public static String readStringFromInputStream(InputStream is) throws IOException {
        if (is == null) {
            return null;
        }

        StringWriter stringWriter = null;

        BufferedWriter writer = null;

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));

            stringWriter = new StringWriter();

            writer = new BufferedWriter(stringWriter);

            int c = -1;
            while ((c = reader.read()) != -1) {
                writer.write(c);
            }
            writer.flush();

            return stringWriter.toString();
        } finally {
            if (is != null)
                is.close();

            if (stringWriter != null)
                stringWriter.close();

            if (writer != null)
                writer.close();
        }
    }

}
