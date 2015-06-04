#include <stdio.h>


void reverse(char *str){
	int end = 0;
	while(str[end]){
		end++;
	}
	end--;
	int middle = end >> 1;
	for(int i=0; i<=middle; i++){
		char tmp = str[end - i];
		str[end - i] = str[i];
		str[i] = tmp;
	}
}

void reverse1(char *str){
	char* end = str;
	while(*end){
		end++;
	}
	end--;
	while(str < end){
		char tmp = *end;
		*end = *str;
		*str = tmp;
		str++;
		end--;
	}
}

int main(){
	char str[] = "hello";
	reverse(str);
	printf("%s\n", str);
	reverse1(str);
	printf("%s\n", str);
	return 0;
}


