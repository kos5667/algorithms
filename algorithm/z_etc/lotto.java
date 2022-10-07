import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class lotto {

    private static String jsonFile = "D:\\lotto.json";

    private static int rcntLotto = 1010;

    private static int cmprLotto = 10;

    public static void main(String[] args) throws ClientProtocolException, IOException, ParseException {
        // try (Scanner scan = new Scanner(System.in)) {
        //     rcntLotto = scan.nextInt();
        //     cmprLotto = scan.nextInt();
        // }

        run();

        //================================
        // createJsonLotto("20");

        // readJsonLotto();
    }

    static void run() throws ClientProtocolException, IOException {
        int[] lotto = new int[6];

        // int[] test = {9,12,15,25,34,36};

        List<List<Integer>> hist = createHistLottoList(rcntLotto);
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        CPR:
        while(true) {
            lotto = getLottoNumber();

            for(int i=0; i<hist.size(); i++) {
                if(compareLotto1(lotto, hist.get(i))) continue CPR;
            }
            
            if(compareLotto2(lotto, hist)) continue;

            break CPR;
        }

        System.out.print("Lotto Number is : ");
        print(lotto);
    }

    @SuppressWarnings("unchecked")
    static List<List<Integer>> createHistLottoList(int num) throws ClientProtocolException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<List<Integer>> list = new ArrayList<>();

        for(int i=0; i<cmprLotto; i++) {
            String body = getLottoHistory(num - i);
            Map<String, Object> map = mapper.readValue(body, Map.class);

            List<Integer> lotto = new ArrayList<>();
            lotto.add(0,(int) map.get("drwtNo1"));
            lotto.add(1,(int) map.get("drwtNo2"));
            lotto.add(2,(int) map.get("drwtNo3"));
            lotto.add(3,(int) map.get("drwtNo4"));
            lotto.add(4,(int) map.get("drwtNo5"));
            lotto.add(5,(int) map.get("drwtNo6"));
            list.add(lotto);
        }
        return list;
    }

    static boolean compareLotto1(int[] arr1, List<Integer> arr2) {
        int sa = 0;
        for(int i=0; i<arr1.length; i++) {
            for(int j=0; j<arr2.size(); j++) {
                if(arr1[i] == arr2.get(j)) sa++;
            }
        }

        if(sa >= 3)
            return true;
        else
            return false;
    }

    static boolean compareLotto2(int[] arr1, List<List<Integer>> arr2) {
        List<Integer> num = new ArrayList<>();
        for(int i=0; i<arr2.size(); i++) { //2
            num.addAll(arr2.get(i));
        }
        
        int du = 0;
        num = num.stream().distinct().collect(Collectors.toList());
        num.sort(Comparator.naturalOrder());
        for(int i=0; i<arr1.length; i++) {
            for(int j=0; j<num.size(); j++) {
                if(arr1[i] == num.get(j)) {
                    du++;
                }
            }
        }

        if(du >= 6) return false;
        else return true;
    }

    /**
     * Create Lotto history json file
     * @param num
     * @throws ClientProtocolException
     * @throws IOException
     */
    static void createJsonLotto(String num) throws ClientProtocolException, IOException {
        JsonObject jsonobject = new JsonObject();
        JsonArray jsonArray = new JsonArray();
        FileWriter writer=null;
        for(int i=1; i<=Integer.parseInt(num); i++) {
            String body = getLottoHistory(i);
            jsonArray.add(body);
        }
        jsonobject.add("lotto", jsonArray);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(jsonobject);

        writer = new FileWriter(jsonFile);
        writer.write(json);
        writer.close();
    }

    /**
     * Read Lotto history Number
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ParseException
     */
    static JSONArray readJsonLotto() throws FileNotFoundException, IOException, ParseException {
        JSONParser parser = new JSONParser();

        Object obj = parser.parse(new FileReader(jsonFile));

        JSONObject jsonObject = (JSONObject) obj;

        JSONArray jsonArray = (JSONArray) jsonObject.get("lotto");

        // JSON Array 추출
        for(int i=0; i<jsonArray.size(); i++) {
            JSONObject json = (JSONObject) parser.parse(jsonArray.get(i).toString());
            System.out.println(json.get("drwNo"));
        }
        return jsonArray;
    }

    // Create Random Lotto Number
    static int[] getLottoNumber() {
        int Lotto[] = new int[6];
        int random = 0;

        for(int i=0; i<6; i++) {
            RAN:while(true) {
                random = (int) (Math.random() * 100 % 45);
    
                if(random == 0) continue RAN;
    
                for(int j=0; j<Lotto.length; j++) {
                    if(random == Lotto[j]) continue RAN;
                }
    
                break;
            }
            Lotto[i] = random;
        }

        Arrays.sort(Lotto);
        return Lotto;
    }

    // Lotto API
    static String getLottoHistory(int num) throws ClientProtocolException, IOException {
        String url = "https://www.dhlottery.co.kr/common.do?method=getLottoNumber&drwNo=" + num;
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(url);
        HttpResponse response = client.execute(request);
        
        ResponseHandler<String> handler = new BasicResponseHandler();
        String body = handler.handleResponse(response);
        return body;
    }
    
    public static void print(int Lotto[]) {
        Arrays.sort(Lotto);
        for(int i=0; i< Lotto.length; i++) {
            System.out.print(Lotto[i] + " ");
        }
        System.out.println();
    }
}
