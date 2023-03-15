// 3
public class SoundClip {
//     fields
    double[] clip;
//     constructors
    public SoundClip() {
        clip = null;
    }
    public SoundClip(double[] fakeClip) {
        clip = fakeClip;
    }
//     methods
//     4
    void adjustVolume(double factor) {
        for (int i = 0; i < clip.length; i++) {
            clip[i] *= factor;
        }
    }
//     5
    void mix(double[] clip1, double[] clip2) {
        clip = new double[clip1.length];
        for (int i = 0; i < clip.length; i++) {
            clip[i] = clip1[i] + clip2[i];
        }
    }
//     6
    void append(double[] other) {
        double[] ans = new double[clip.length + other.length];
        for (int i = 0; i < ans.length; i++) {
            if (i < clip.length) ans[i] = clip[i];
            else ans[i] = other[i - clip.length];
        }
        clip = ans;
    }
//    7
    void fadeIn(double seconds) {
        int numValues = Sound.toNumSamples(seconds);
        for (int i = 0; i < numValues; i++) {
            clip[i] *= (double) i / numValues;
        }
    }
//     8
    void fadeOut(double seconds) {
        int numValues = Sound.toNumSamples(seconds);
        for (int i = clip.length - 1; i >= clip.length - numValues; i--) {
            clip[i] *= (double) (clip.length - i) / numValues;
        }
    }
//     9
    void reverse() {
        for (int i = 0; i < clip.length/2; i++) {
            double temp = clip[i];
            clip[i] = clip[clip.length - 1 - i];
            clip[clip.length - 1 - i] = temp;
        }
    }
//    10
    void speedUp(double factor) {
        double[] newClip = new double[(int) (clip.length/factor)];
        for (int i = 0; i < clip.length; i++){
            newClip[(int) (i / factor)] = clip[i];
        }
        clip = newClip;
    }


}
