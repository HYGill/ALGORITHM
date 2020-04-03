package PROGRAMMERS.카카오인턴쉽2019;

public class 멀쩡한사각형 {
    public static void main(String[] args) {
        int w = 8;
        int h = 12;

        // w + h - 최대공약수
        System.out.println(solution(h, w));
    }

    static public long solution(int w, int h) {
        long wl = Long.parseLong(String.valueOf(w));
        long hl = Long.parseLong(String.valueOf(h));

        return wl * hl - (wl + hl - GCD(w, h));
    }

    // 최대공약수
    public static long GCD(int w, int h) {
        if(w % h == 0)
            return h;
        return GCD(h, w % h);
    }
    // 최소공배수 = (a * b / 최대공약수)
}