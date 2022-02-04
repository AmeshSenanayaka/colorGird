package com.color.adjacent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.List;

/* ==============================================================
 *  Author :Amesh Senanayaka
 *  Date   : 29/01/2022 - 19:00 PM
 *  Description :Grid Color Filter
 * ==============================================================
 **/
public class ColorFinder {

	private final Logger logger = LoggerFactory.getLogger(ColorFinder.class);
	/*
	 * Iterate Grid Node and Find same color blocks count
	 */
    public Map<String,Integer> findBlockColors(Node[][] gridColors){

		logger.info("call findBlockColor()");
		int block =1;
        Map<String,Integer> colorCount = new HashMap<>();

        for(int y=0;y<AdjacentApplication.getRow();y++){

            for(int x =0;x<AdjacentApplication.getCol();x++){
            	
            	Node node = gridColors[y][x];
            	int blockCount = 0;
            	if(node.isMark())
            		continue;
            	
            	List<Node> sameNodesFromAround = new ArrayList<>();
				getSameColorNeighbors(node,gridColors,sameNodesFromAround);//get same color node from around

            	if(sameNodesFromAround.isEmpty())
            		blockCount++;
            
            	for(Node cn: sameNodesFromAround) {
            		blockCount++;
            	}
            	
            	colorCount.put((block++) + node.getColor().toString(), blockCount);
            	
            }	

        }
		logger.info("end findBlockColor()");
        return colorCount;
    }


	/*
	 * Find same color neighbor by a node
	 */
    private void getSameColorNeighbors(Node node, Node[][] gridColors, List<Node> sameNodesFromAround) {
    	List<Node> sameColorNodes = new ArrayList<>();
		logger.info("call getSameColorNeighbors() for "+node.toString());

		if(node.getY() > 0 ) {
    		Node upNode = gridColors[node.getY()-1][node.getX()];
    		if(!upNode.isMark() && upNode.getColor().equals(node.getColor())) {
        		sameColorNodes.add(upNode);
        		upNode.setMark(true);
        	}
    	}
    	
    	if(node.getY() < AdjacentApplication.getRow()-1 ) {
    		Node downNode = gridColors[node.getY()+1][node.getX()];
    		if(!downNode.isMark() && downNode.getColor().equals(node.getColor())) {
        		sameColorNodes.add(downNode);
        		downNode.setMark(true);
        	}
    	}
    	
    	if(node.getX()>0) {
    		Node leftNode = gridColors[node.getY()][node.getX()-1];
    		if(!leftNode.isMark() && leftNode.getColor().equals(node.getColor())) {
        		sameColorNodes.add(leftNode);
        		leftNode.setMark(true);
        	}
    	}
    	
    	if(node.getX() < AdjacentApplication.getCol()-1) {
    		Node rightNode = gridColors[node.getY()][node.getX()+1];
    		if(!rightNode.isMark() && rightNode.getColor().equals(node.getColor())) {
        		sameColorNodes.add(rightNode);
        		rightNode.setMark(true);
        	}
    	}
    	
    	sameNodesFromAround.addAll(sameColorNodes);
    	
    	if(!sameColorNodes.isEmpty()) {
    		for(Node n :sameColorNodes) {
				getSameColorNeighbors(n,gridColors,sameNodesFromAround);
    			
    		}
    	}

		logger.info("end getSameColorNeighbors() ");
    	
	}





}
