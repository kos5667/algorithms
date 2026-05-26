package level2;

import java.util.*;

/**
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/42577">...</a>
 * @title 전화번호 목록
 * @tag 해시
 */
public class Q42577 {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);

        for (int i = 0; i < phone_book.length -1; i++) {
            if (phone_book[i+1].startsWith(phone_book[i])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[][] book  = {
                // 기본 접두사 충돌
                {"119", "97674223", "1195524421"},

                // 충돌 없음
                {"123", "456", "789"},

                // 여러 접두사 충돌
                {"12", "123", "1235", "567", "88"},

                // 완전 동일
                {"111", "111"},

                // 짧은 번호가 접두사
                {"1", "123", "456"},

                // 마지막에서 충돌
                {"555", "666", "777", "7778"},

                // 정렬해야 발견되는 케이스
                {"4567", "123", "456"},

                // 길이가 다양한 경우
                {"9", "91", "911", "9112", "98"},

                // 접두사 전혀 없음
                {"321", "654", "987", "741"},

                // 숫자 많은 케이스
                {"100", "1000", "10000", "200", "300"},

                // 한 자리 번호
                {"1", "2", "3", "4"},

                // 중간에서 충돌
                {"888", "777", "777123", "999"},

                // 긴 번호
                {"123456789", "123456", "987654321"},

                // 모두 같은 시작
                {"5", "51", "512", "5123", "51234"},

                // 랜덤
                {"234", "7890", "56789", "12345", "678"}
        };

        for (String[] phone_book : book) {
            System.out.println(new Q42577().solution(phone_book));
            System.out.println("---------");
        }
    }
}
