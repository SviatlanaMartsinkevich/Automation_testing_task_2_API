package models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@AllArgsConstructor
@Data
@Builder
@NoArgsConstructor
public class Root {
    public int count;
    public Object next;
    public Object previous;
    public ArrayList<Result> results;
}
