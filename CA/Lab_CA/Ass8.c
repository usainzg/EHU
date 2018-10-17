#include <stdio.h>
#include <stdlib.h>

struct Member {
    char name[40];
    int age;
    int member_id;
};

void read_data_file(FILE *f, struct Member *m, int *nMembers)
{
    int i = 0;
    while(!feof(f)) {
        fscanf(f,"%s", m[i].name);
        fscanf(f,"%d", &m[i].age);
        fscanf(f,"%d", &m[i].member_id);
        i += 1;
    }

    *nMembers = i;
}

void write_youngest(struct Member *m, int nMembers)
{
    int youngest = m[0].age;
    for(int i = 1; i < nMembers; i++) {
        if(m[i].age < youngest) youngest = m[i].age;
    }

    printf("Youngest: %d\n", youngest);

    FILE *f = fopen("/Users/usainzg/Documents/EHU/CA/Lab_CA/ForAssignments/memyoungest.dat", "w");
    for(int i = 0; i < nMembers; i++) {
        if(m[i].age == youngest) {
            fprintf(f,"%s ", m[i].name);
            fprintf(f,"%d ", m[i].age);
            fprintf(f,"%d\n", m[i].member_id);
        }
    }
    fclose(f);
}

void write_oldest(struct Member *m, int nMembers)
{
    int oldest = m[0].age;

    for(int i = 1; i < nMembers; i++) {
        if(m[i].age > oldest) oldest = m[i].age;
    }

    printf("Oldest: %d\n", oldest);

    FILE *f = fopen("/Users/usainzg/Documents/EHU/CA/Lab_CA/ForAssignments/moldest.dat", "w");
    for(int i = 0; i < nMembers; i++) {
        if(m[i].age == oldest) {
            fprintf(f,"%s ", m[i].name);
            fprintf(f,"%d ", m[i].age);
            fprintf(f,"%d\n", m[i].member_id);
        }
    }
    fclose(f);
}

void write_retired(struct Member *m, int nMembers)
{
    FILE *f = fopen("/Users/usainzg/Documents/EHU/CA/Lab_CA/ForAssignments/mretired.dat", "w");
    for(int i = 0; i < nMembers; i++) {
        if(m[i].age > 65) {
            fprintf(f,"%s ", m[i].name);
            fprintf(f,"%d ", m[i].age);
            fprintf(f,"%d\n", m[i].member_id);
        }
    }
    fclose(f);
}

int main(int argc, char* argv[])
{
    FILE *f;
    f = fopen(argv[2], "r");
    struct Member m[600];
    int nMembers = 0;
    int input = -1;
    read_data_file(f, m, &nMembers);
    fclose(f);

    do {
        printf("---Select Operation--- \n");
        printf("1: Youngest\n");
        printf("2: Oldest\n");
        printf("3: Retired\n");
        printf("-1: Exit\n");
        scanf("%d", &input);
        switch(input) {
            case 1:
                write_youngest(m, nMembers);
            break;
            case 2:
                write_oldest(m, nMembers);
            break;
            case 3:
                write_retired(m, nMembers);
            break;
            default:
            break;
        }
    } while(input != -1);

    return 0;
}
