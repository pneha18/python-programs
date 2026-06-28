#include <stdio.h>
#include <string.h>

int main() {

    char courses[6][40] = {
        "Mathematics",
        "Physics",
        "Chemistry",
        "Computer Science",
        "Artificial Intelligence",
        "Data Structures"
    };

    char registered[6][40];
    int count = 0;

    int option, choice;
    int i, j, found;

    printf("=====================================================\n");
    printf("        WELCOME TO COURSE REGISTRATION SYSTEM\n");
    printf("=====================================================\n");

    while(1) {

        printf("\n**************** MAIN MENU ****************\n");
        printf("1. View Available Courses\n");
        printf("2. Register a Course\n");
        printf("3. View Registered Courses\n");
        printf("4. Full Detailed Report\n");
        printf("5. Exit\n");
        printf("*******************************************\n");

        printf("Enter your choice: ");
        scanf("%d", &option);

        switch(option) {

            case 1:
                printf("\n=====================================================\n");
                printf("              AVAILABLE COURSE LIST\n");
                printf("=====================================================\n");

                for(i = 0; i < 6; i++) {
                    printf("Course No : %d\n", i + 1);
                    printf("Course Name : %s\n", courses[i]);
                    printf("Course Credits : 4\n");
                    printf("Course Duration : 1 Semester\n");
                    printf("-----------------------------------------------------\n");
                }
                break;

            case 2:
                if(count >= 6) {
                    printf("\nMaximum course limit reached!\n");
                    break;
                }

                printf("\nEnter course number to register: ");
                scanf("%d", &choice);

                if(choice < 1 || choice > 6) {
                    printf("Invalid choice!\n");
                    break;
                }

                found = 0;
                for(j = 0; j < count; j++) {
                    if(strcmp(registered[j], courses[choice - 1]) == 0) {
                        found = 1;
                        break;
                    }
                }

                if(found) {
                    printf("\n=====================================================\n");
                    printf("Course Already Registered!\n");
                    printf("=====================================================\n");
                } else {
                    strcpy(registered[count], courses[choice - 1]);
                    count++;

                    printf("\n=====================================================\n");
                    printf("        REGISTRATION SUCCESSFUL\n");
                    printf("=====================================================\n");
                    printf("Course Name : %s\n", courses[choice - 1]);
                    printf("Status      : Confirmed\n");
                    printf("Credits     : 4\n");
                    printf("Instructor  : Faculty %d\n", count);
                    printf("-----------------------------------------------------\n");
                }
                break;

            case 3:
                printf("\n=====================================================\n");
                printf("            REGISTERED COURSE LIST\n");
                printf("=====================================================\n");

                if(count == 0) {
                    printf("No courses registered yet!\n");
                } else {
                    for(i = 0; i < count; i++) {
                        printf("%d. %s\n", i + 1, registered[i]);
                    }
                }
                printf("-----------------------------------------------------\n");
                break;

            case 4:
                printf("\n=====================================================\n");
                printf("               FULL DETAILED REPORT\n");
                printf("=====================================================\n");

                if(count == 0) {
                    printf("No courses registered.\n");
                } else {
                    for(i = 0; i < count; i++) {

                        printf("\n*********************************************\n");
                        printf("Course Number        : %d\n", i + 1);
                        printf("Course Name          : %s\n", registered[i]);
                        printf("Course Code          : CSE%d\n", 101 + i);
                        printf("Department           : Computer Science\n");
                        printf("Credits              : 4\n");
                        printf("Duration             : 6 Months\n");
                        printf("Instructor Name      : Faculty %d\n", i + 1);
                        printf("Class Timing         : 10:00 AM - 11:00 AM\n");
                        printf("Room Number          : Block A - %d\n", 201 + i);
                        printf("Status               : Registered Successfully\n");
                        printf("*********************************************\n");
                    }
                }
                break;

            case 5:
                printf("\n=====================================================\n");
                printf("     THANK YOU FOR USING REGISTRATION SYSTEM\n");
                printf("=====================================================\n");
                return 0;

            default:
                printf("\nInvalid option! Please try again.\n");
        }
    }

    return 0;
}
