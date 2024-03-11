import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HiCrdev {
    static public void main(String[] args) {
        List<TransferAssignPresentingObject> source = new ArrayList<>();

        source.add(TransferAssignPresentingObject.of("", "전 담당자 1", "핸들러 1", "배분", Instant.now().minus(1, ChronoUnit.DAYS)));
        source.add(TransferAssignPresentingObject.of("", "전 담당자 2", "핸들러 2", "회수", Instant.now().minus(2, ChronoUnit.DAYS)));
        source.add(TransferAssignPresentingObject.of("", "전 담당자 3", "핸들러 3", "회수", Instant.now().minus(3, ChronoUnit.DAYS)));
        source.add(TransferAssignPresentingObject.of("", "전 담당자 4", "핸들러 4", "회수", Instant.now().minus(4, ChronoUnit.DAYS)));
        source.add(TransferAssignPresentingObject.of("", "전 담당자 5", "핸들러 5", "배분", Instant.now().minus(5, ChronoUnit.DAYS)));
        source.add(TransferAssignPresentingObject.of("", "전 담당자 6", "핸들러 6", "배분", Instant.now().minus(6, ChronoUnit.DAYS)));
        source.add(TransferAssignPresentingObject.of("", "전 담당자 7", "핸들러 7", "회수", Instant.now().minus(7, ChronoUnit.DAYS)));
        source.add(TransferAssignPresentingObject.of("", "전 담당자 8", "핸들러 8", "배분", Instant.now().minus(8, ChronoUnit.DAYS)));


        List<TransferAssignPresentingObject> viewData = source.stream()
                // 여기에 Collection Chain-Function 을 작성해 주세요.
                .collect(Collectors.toList());


        log.info("source data: {}", source);
        log.info("presentation data: {}", viewData);
    }


    @Data
    @NoArgsConstructor
    @AllArgsConstructor(staticName = "of")
    public static class TransferAssignPresentingObject {

        private String transferRemark;

        // 이관 받은 담당자
        private String beforeAgeName;

        // 전달자
        private String handlerAgeName;

        // 상태값 구분
        private String type;

        // (이관/분배)[공통] 받은 일시
        private Instant createdAt;

        @Override
        public String toString() {
            return String.format("\n\t{ %s, %s, %s}", this.handlerAgeName, this.type, this.createdAt.atZone(ZoneId.systemDefault()).toLocalDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        }
    }
}