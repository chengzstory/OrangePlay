import com.chengzstory.orangeplay.domain.constant.MsgCenter;
import com.chengzstory.orangeplay.exception.GameException;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by chengzstory on 2018/3/2.
 */
public class NickNameTest {
    public static void test(String nickname) {
        if (StringUtils.isBlank(nickname) || nickname.length() >= 20) {
            throw new GameException(MsgCenter.ERROR_NICINAME);
        }
    }

    public static void main(String args[]) {
        test("123");
    }
}
