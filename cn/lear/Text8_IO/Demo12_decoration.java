package cn.lear.Text8_IO;

/**
 * @description: IO使用的处理模式：装饰处理模式。
 * 以下只是演示。
 * @Time: 2018/8/15 16:33
 */
public class Demo12_decoration {

    public static void main(String[] args) {
        Voice voice = new Voice();
        voice.say();
        Amplifier amp = new Amplifier(voice);
        amp.say();

    }

}

class Voice {
    private int voice = 10;

    public Voice() {
    }

    public int getVoice() {
        return voice;
    }

    public void setVoice(int voice) {
        this.voice = voice;
    }

    public void say() {
        System.out.println(getVoice());

    }

    public Voice(int voice) {
        this.voice = voice;
    }
}

class Amplifier {
    private Voice voice;

    public Amplifier() {

    }

    public Amplifier(Voice voice) {
        this.voice = voice;
    }

    public void say() {
        voice.setVoice(voice.getVoice() * 1000);
        System.out.println(voice.getVoice());
    }
}