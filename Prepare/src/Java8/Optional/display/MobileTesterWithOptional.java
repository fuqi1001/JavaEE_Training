package Java8.Optional.display;

import java.util.Optional;

public class MobileTesterWithOptional {
    public static void main(String[] args) {
        ScreenResolution resolution = new ScreenResolution(750, 1334);
        DisplayFeatures dfeatures = new DisplayFeatures("4.7", Optional.of(resolution));
        Mobile mobile = new Mobile(2015001, "Apple", "6s", Optional.of(dfeatures));

        MobileService mService = new MobileService();

        int width = mService.getMobileScreenWidth(Optional.of(mobile));
        System.out.println("Apple 6s Screen with = " + width);

        Mobile mobile2 = new Mobile(2015001, "Apple", "6s", Optional.empty());
        int width2 = mService.getMobileScreenWidth(Optional.of(mobile2));
        System.out.println("Apple iphone 6s Screen width = " + width2);
    }
}
