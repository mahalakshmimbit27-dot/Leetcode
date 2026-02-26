class Solution {
    public String validIPAddress(String queryIP) {
        if (queryIP.chars().filter(ch -> ch == '.').count() == 3) {
            return validateIPv4(queryIP);
        } else if (queryIP.chars().filter(ch -> ch == ':').count() == 7) {
            return validateIPv6(queryIP);
        } else {
            return "Neither";
        }
    }

    private String validateIPv4(String IP) {
        // limit -1 ensures trailing empty strings are not ignored (e.g., "1.1.1.")
        String[] segments = IP.split("\\.", -1);
        if (segments.length != 4) return "Neither";
        for (String s : segments) {
            if (s.isEmpty() || s.length() > 3) return "Neither";
            if (s.charAt(0) == '0' && s.length() > 1) return "Neither";
            for (char ch : s.toCharArray()) {
                if (!Character.isDigit(ch)) return "Neither";
            }
            int val = Integer.parseInt(s);
            if (val < 0 || val > 255) return "Neither";
        }
        return "IPv4";
    }

    private String validateIPv6(String IP) {
        String[] segments = IP.split(":", -1);
        if (segments.length != 8) return "Neither";
        String hexDigits = "0123456789abcdefABCDEF";
        for (String s : segments) {
            if (s.isEmpty() || s.length() > 4) return "Neither";
            for (char ch : s.toCharArray()) {
                if (hexDigits.indexOf(ch) == -1) return "Neither";
            }
        }
        return "IPv6";
    }
}
