package com.interview.vais;

//        Given a non-empty list of positive integers l and a target positive integer t, write a function solution(l, t)
//        which verifies if there is at least one consecutive sequence of positive integers within the list l
//        (i.e. a contiguous sub-list) that can be summed up to the given target positive integer t (the key) and
//        returns the first list containing the smallest start and end indexes where this sequence can be found, or
//        returns the array [-1, -1] in the case that there is no such sequence
//
//        For example, given the list l as [4, 3, 5, 7, 8] and the key t as 12, the function solution(l, t) would return
//        the list [0, 2] because the list l contains the sub-list [4, 3, 5] starting at index 0 and ending at index 2,
//        for which 4 + 3 + 5 = 12, even though there is a shorter sequence that happens later in the list (5 + 7).
//        On the other hand, given the list l as [1, 2, 3, 4] and the key t as 15, the function solution(l, t)
//        would return [-1, -1] because there is no sub-list of list l that can be summed up to the given target
//        value t = 15.

public class Solution_12_2022 {

    public static void main(String[] args) {
        int[] list = {4, 3, 5, 7, 8};
        int[] list2 = {3, 5, 8, 9, 13};

        int[] resultQuadratic = solutionQuadratic(list, 12);
        int[] resultLinear = solutionLinear(list2, 15);
        System.out.println("Result quadratic: [" + resultQuadratic[0] + ", " + resultQuadratic[1] + "]");
        System.out.println("Result linear: [" + resultLinear[0] + ", " + resultLinear[1] + "]");
    }

    public static int[] solutionQuadratic(int[] elements, int target) {
        int sum = 0;

        for (int i = 0; i < elements.length; i++) {
            sum = elements[i];
            if (sum == target) {
                return new int[]{i, i};
            }

            for (int j = i + 1; j < elements.length; j++) {
                sum = elements[j] + sum;
                if (target == sum) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }

    public static int[] solutionLinear(int[] elements, int target) {
        int start = 0;
        int end = 0;
        int currentSum = 0;

        while (end < elements.length) {
            currentSum += elements[end];

            while (currentSum > target && start <= end) {
                currentSum -= elements[start];
                start++;
            }

            if (currentSum == target) {
                return new int[]{start, end};
            }

            end++;
        }

        return new int[]{-1, -1};
    }
}

// WRITE A TEST FOR TASK ABOVE
//
//    public parameters(){
//        int[] list = {4, 3, 5, 7, 8};
//        int[] list = {1, 2, 3, 4, 5};
//    }
//
//    @Test
//    public void test(){
//        int[] list = {4, 3, 5, 7, 8};
//        int target = 12;
//        int[] expected = {0, 2};
//
//        int[] actual = solution(list, target);
//
//        assertEquals(actual, expected);
//    }


// FIND A PROBLEM IN CODE BELOW (n + 1 problem in 135 line)
//
//@Entity
//@Table
//public class Author {
//
//    @Id
//    private Long id;
//
//    private String name;
//
//    @OneToMany
//    @JoinTable(...)
//    private List<Book> books;
//
//  ... getters and setters
//
//}

//@Entity
//@Table
//public class Book {
//
//    @Id
//    private Long id;
//
//    private String title;
//
//   ... getters and setters
//}
//
//
//
//public class AuthorService {
//
//    public List<AuthorDTO> getAll(<params>){
//
//        List<Author> authors = authorDao.getAll(<params>);
//
//        List<AuthorDTO> result = authors.stream().map(
//                a -> {
//                    AuthorDTO dto = new AuthorDTO();
//                    dto.setId(a.getId());
//                    dto.setName(a.getName());
//                    List<BookDTO> books = new ArrayList<>();
//                    for(Book b : a.getBooks()){           // n + 1 problem in this line
//                        BookDTO bDTO = new BookDTO();
//                        bDTO.setId(b.getId());
//                        bDTO.setTitle(b.getTitle());
//                        books.add(bDTO);
//                    }
//                    dto.setBooks(books);
//                    return dto;
//                }
//        ).collect(Collectors.toList());
//        return result;
//    }
//}