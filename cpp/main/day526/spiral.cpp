#include <cstdlib> 
#include <fstream>
#include <iostream>


const int WIDTH = 5;
const int HEIGHT = 3;

void runSpiral(int arr[HEIGHT][WIDTH]){
    int maxX = WIDTH;
    int maxY = HEIGHT;
    int minX = 0, minY = 0;
    int x = 0, y = 0;
    int iter = 0;
    while (maxX > minX && maxY > minY) {
        int modIter = iter % 4;
        switch (modIter)
        {
        case 3:
            for (int i = y; i >= minY; i--) {
                std::cout << arr[i][x] <<  std::endl;
            }
            y = minY;
            minX = minX + 1;
            x = minX;
            break;
        case 2:
            for (int i = x; i >= minX; i--) {
                std::cout << arr[y][i] << std::endl;
            }
            x = minX;
            maxY = maxY - 1;
            y = maxY - 1;
            break;
        case 1:
            for (int i = y; i < maxY; i++) {
                std::cout << arr[i][x] <<  std::endl;
            }
            y = maxY - 1;
            maxX = maxX - 1;
            x = maxX - 1;
            break;
        case 0:
        default:
            for (int i = x; i < maxX; i++) {
                std::cout << arr[y][i] <<  std::endl;
            }
            x = maxX - 1;
            minY = minY + 1;
            y = minY;
            break;
        }
        iter++;
    }
    std::cout << "Done!" << std::endl;
}


void printArray(int arr[][WIDTH], int width, int length){
    for (int i = 0; i < HEIGHT; i++){
        for (int j = 0; j < WIDTH; j++){
            int value = arr[i][j]; 
            std::cout << value <<  " ";
        }
    }
}

void range(int max, int* ranger){
    int n = 0;
    while (n < max){
        ranger[n] = n;
        n += 1;
    }
 
}


int main() {
    int a [HEIGHT][WIDTH] = {{1, 2, 4, 5, 6}, {2, 3, 7, 8, 9}, {4, 5, 10, 11, 12}};
    runSpiral(a);
    return 0;
}