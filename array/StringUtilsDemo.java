package leet.array;

import org.apache.commons.lang.StringUtils;

public class StringUtilsDemo {

    public static void main(String[] args) {
        String url ="/content/amazon/us/en/articles/learning/june-2020-release/june-2020-release-v1.2.pdf";
        if (org.apache.commons.lang.StringUtils.startsWith(url, "/content/amazon/")) {
            url = org.apache.commons.lang.StringUtils.replace(url, "/content/amazon/", org.apache.commons.lang.StringUtils.EMPTY);
        }
        int indexOfSlash = url.indexOf('/');
        if (indexOfSlash >= 0 && indexOfSlash + 1 < url.length()) {
            url = StringUtils.substring(url, indexOfSlash + 1, 5);
        }
        System.out.println(url);
    }
}
