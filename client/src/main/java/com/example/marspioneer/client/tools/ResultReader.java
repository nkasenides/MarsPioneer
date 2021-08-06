package com.example.marspioneer.client.tools;

import com.google.gson.Gson;
import com.raylabz.javahttp.BasicHTTPRequest;
import com.raylabz.javahttp.BasicHTTPResponse;
import com.raylabz.javahttp.OnSuccessListener;
import com.raylabz.javahttp.RequestMethod;

public class ResultReader {

    public static void main(String[] args) {

        BasicHTTPRequest.create("http://localhost:8080/results/get", RequestMethod.GET)
                .onSuccess(new OnSuccessListener<BasicHTTPResponse>() {
                    @Override
                    public void onSuccess(BasicHTTPResponse response) throws Exception {
                        Gson gson = new Gson();
                        final ResultType result = gson.fromJson(response.getContent(), ResultType.class);

                        int sumSessionValidation = 0;
                        for (Long aLong : result.getSessionValidation()) {
                            System.out.print(aLong + "\t");
                            sumSessionValidation += aLong;
                        }
                        System.out.println();
                        double averageSessionValidation = sumSessionValidation / (double) result.getSessionValidation().size();
                        System.out.println("Average session validation\t" + averageSessionValidation);



                        int sumStateRetrieval = 0;
                        for (Long aLong : result.getStateRetrieval()) {
                            System.out.print(aLong + "\t");
                            sumStateRetrieval += aLong;
                        }
                        System.out.println();
                        double averageStateRetrieval = sumStateRetrieval / (double) result.getStateRetrieval().size();
                        System.out.println("Average state retrieval\t" + averageStateRetrieval);




                        int sumRuleProcessing = 0;
                        for (Long aLong : result.getRuleProcessing()) {
                            System.out.print(aLong + "\t");
                            sumRuleProcessing += aLong;
                        }
                        System.out.println();
                        double averageRuleProcessing = sumRuleProcessing / (double) result.getRuleProcessing().size();
                        System.out.println("Average rule processing\t" + averageRuleProcessing);




                        int sumStateModification = 0;
                        for (Long aLong : result.getStateModification()) {
                            System.out.print(aLong + "\t");
                            sumStateModification += aLong;
                        }
                        System.out.println();
                        double averageStateModification = sumStateModification / (double) result.getStateModification().size();
                        System.out.println("Average state modification\t" + averageStateModification);




                        int sumStateSend = 0;
                        for (Long aLong : result.getStateSend()) {
                            System.out.print(aLong + "\t");
                            sumStateSend += aLong;
                        }
                        System.out.println();
                        double averageStateSend = sumStateSend / (double) result.getStateSend().size();
                        System.out.println("Average state send\t" + averageStateSend);





                        int sumTotal = 0;
                        for (Long aLong : result.getTotal()) {
                            System.out.print(aLong + "\t");
                            sumTotal += aLong;
                        }
                        System.out.println();
                        double averageTotal = sumTotal / (double) result.getTotal().size();
                        System.out.println("Average total\t" + averageTotal);




                    }
                })
                .build()
                .sendAndWait();

    }

}
