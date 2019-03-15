package nut.and.bolt.problem;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class BoltAndNutPairerService implements NutAndBoltPairer {


	/**
	 * @returns - a List of List which comprises of 3 Lists.
	 *              first is a list of Paired Nuts and Bolts.
	 *              second list is list of unpaired nuts.
	 *              third list is list of unpaired bolts.
	 */
	public List<Object> pairNutAndBolts(List<Nut> nuts, List<Bolt> bolts) {
		List<Nut> unpairedNuts = new LinkedList<Nut>();
		List<Bolt> unpairedBolts = new LinkedList<Bolt>();
		List<NutBoltPair> nutBoltPairs = new LinkedList<NutBoltPair>();
		return pairNutAndBoltsUtil(nuts, bolts, unpairedNuts, unpairedBolts, nutBoltPairs);
	}

	private List<Object> pairNutAndBoltsUtil(List<Nut> nuts, List<Bolt> bolts, List<Nut> unpairedNut, List<Bolt> unpairedBolt, List<NutBoltPair> nutBoltPairs) {

		//Base Case
		if(bolts.size() == 0 || nuts.size() == 0) {
			List<Object> result  = new LinkedList<Object>();
			result.add(nutBoltPairs);
			result.add(unpairedNut.addAll(nuts)); 
			result.add(unpairedBolt.addAll(bolts));
			return result;
		}
		List<Nut> smallerNuts = new LinkedList<Nut>();
		List<Nut> largerNuts = new LinkedList<Nut>();
		List<Bolt> smallerBolts = new LinkedList<Bolt>();
		List<Bolt> largerBolts = new LinkedList<Bolt>();

		Bolt pairedBolt = bolts.get(0);
		Nut pairedNut = null;
		
		for(Nut nut : nuts) {
			if(NutAndBoltComparator.compareNutAndBolt(nut, pairedBolt) > 0)
				largerNuts.add(nut);
			if(NutAndBoltComparator.compareNutAndBolt(nut, pairedBolt) < 0)
				smallerNuts.add(nut);
			else
				pairedNut = nut;
		}

		if(pairedNut != null) {
			for(Bolt bolt : bolts) {
				if(NutAndBoltComparator.compareNutAndBolt(pairedNut, bolt) > 0)
					smallerBolts.add(bolt);
				if(NutAndBoltComparator.compareNutAndBolt(pairedNut, bolt) < 0)
					largerBolts.add(bolt);
			}
		} else {
			// The chosen bolt had no pair.
			if(unpairedBolt == null)
				unpairedBolt = new LinkedList<Bolt>();
			unpairedBolt.add(pairedBolt);
			bolts.remove(pairedBolt);
			return pairNutAndBoltsUtil(nuts, bolts, unpairedNut, unpairedBolt, nutBoltPairs);
		}

		List<Object> resultForSmallerBolts = pairNutAndBoltsUtil(smallerNuts, smallerBolts, unpairedNut, unpairedBolt, nutBoltPairs);
		List<Object> resultForLargerBolts = pairNutAndBoltsUtil(largerNuts, largerBolts, unpairedNut, unpairedBolt, nutBoltPairs);

		return mergeResult(resultForSmallerBolts, resultForLargerBolts, pairedNut, pairedBolt, unpairedNut, unpairedBolt);

	}


	private List<Object> mergeResult(List<Object> firstResult, List<Object> secondResult, Nut pairedNut, Bolt pairedBolt, List<Nut> unpairedNut, List<Bolt> unpairedBolt) {

		List<Object> unpairedNuts = new LinkedList<Object>();
		List<Object> unpairedBolts = new LinkedList<Object>();
		List<Object> pairedNutsAndBolts = new LinkedList<Object>();

		// All paired nuts and bolts
		pairedNutsAndBolts.addAll( (Collection)firstResult.get(0));
		pairedNutsAndBolts.addAll( (Collection)secondResult.get(0));
		if(pairedNut != null)
			pairedNutsAndBolts.add(new NutBoltPair(pairedNut, pairedBolt));

		// merging unpaired nuts list
		unpairedNuts.addAll(unpairedNut);
		unpairedNuts.addAll((Collection)firstResult.get(1));
		unpairedNuts.addAll((Collection)secondResult.get(1));

		// merging unpaired bolts list
		unpairedBolts.addAll(unpairedBolt);
		unpairedBolts.addAll((Collection)firstResult.get(2));
		unpairedBolts.addAll((Collection)secondResult.get(2));

		//consolidating to list of list
		List<Object> result = new LinkedList(); 
		result.add(pairedNutsAndBolts);
		result.add(unpairedNuts);
		result.add(unpairedBolts);

		return result;

	}

}
