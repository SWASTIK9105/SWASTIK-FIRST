#include <stdio.h>
#include <time.h>
#include <unistd.h>
#include <stdlib.h>

int main() {
    int h = 0, m = 0, s = 0;
    while (1) {
        system("clear");
        printf("%02d : %02d : %02d", h, m, s);
        fflush(stdout);
        s++;
        if (s == 60) {
            m += 1;
            s = 0;
        }
        if (m == 60) {
            h += 1;
            m = 0;
        }
        if (h == 24) {
            h = 0;
            m = 0;
            s = 0;
        }
        sleep(1);
    }
    return 0;
}

