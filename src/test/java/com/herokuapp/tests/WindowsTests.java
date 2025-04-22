package com.herokuapp.tests;

import com.herokuapp.core.TestBase;
import org.junit.jupiter.api.Test;

public class WindowsTests extends TestBase {
    // тут должен быть @BeforeEach? По сути, у нас ведь только одно предусловие на этом сайте - зайти на сайт, и это предусловие прописано в классе TestBase (1:22:30)
    @Test
    public void waitTest(){
        //может понадобиться, если где-то будут алерты с ожиданием.
    }
}
